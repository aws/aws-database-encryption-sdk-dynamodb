#!/usr/bin/env node
// This script takes 2 .rs files into argument.
// The first one is a rust file written by hand that compiles and contains corrected modules
// The second one is a generated contains the same modules as the first one but in a possibly different order, plus the modules are wrong.
// This script is going to reorder the modules of the first rust file written by hand so that it aligns with the second one
// and we can truly compare them.

const fs = require('fs');
if(process.argv.length < 5) {
    console.log("Usage: node reorder.js <ground truth wrong order> <uncompilable correct order> <output_file>");
    process.exit(1);
}
/*
All modules look like top-level pub mod { ... } so we can just split the first file along these to extract them,
look them up in the second file to determine their order, and reconcatenate everything
*/
const groundTruthWrongOrder = process.argv[2];
const uncompilableCorrectOrder = process.argv[3];
const outputFile = process.argv[4];
const groundTruthWrongOrderContent = fs.readFileSync(groundTruthWrongOrder).toString();
const uncompilableCorrectOrderContent = fs.readFileSync(uncompilableCorrectOrder).toString();
const groundTruthWrongOrderModules = groundTruthWrongOrderContent.split(/^(?=pub mod )/);
const uncompilableCorrectOrderModules = uncompilableCorrectOrderContent.split(/^(?=pub mod )/);
// Everything that is not pub mode is assigned 0
let positionInUncompilable = {};
let i = 0;
for(let module of uncompilableCorrectOrderModules) {
  // We need to extract the potential module name
  const r = /pub mod (\S+)/;
  var match;
  if(match = module.match(r)) {
    const moduleName = match[1];
    positionInUncompilable[moduleName] = i;
  }
  i++;
}
// Now sort the groundTruthEtc.

groundTruthWrongOrderModules.sort((module1, module2) => {
    const r = /pub mod (\S+)/;
    var match1;
    var match2;
    if(match1 = module1.match(r)) {
        const moduleName1 = match1[1];
        if(match2 = module2.match(r)) {
            const moduleName2 = match2[1];
            return positionInUncompilable[moduleName1] - positionInUncompilable[moduleName2];
        }
    }
    return 0;
});

// Now emit the code to the output file
const outputContent = groundTruthWrongOrderModules.join("");
fs.writeFileSync(outputFile, outputContent);