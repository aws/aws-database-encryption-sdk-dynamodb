// This script takes 2 .rs files into argument.
// The first one is the ground truth and contains corrected modules
// The second one is supposed to contain the same modules as the first one plus others,
// but the modules are wrong.
// This script is going to index the modules of the first file, and whenever it can find them in the second
// it will replace them.

const fs = require('fs');
if(process.argv.length < 5) {
    console.log("Usage: node pr.js <ground truth> <wrong> <output>");
    process.exit(1);
}
const groundTruth = process.argv[2];
const wrong = process.argv[3];
const output = process.argv[4];
const contentTruth = fs.readFileSync(groundTruth, 'utf8');
// Let's index the contentTruth. All modules start with "pub mod (name without space) {" and end with "}"
const regex = /pub mod (.*?) \{[\s\S]*?\n\}/g;
const modules = {};
var match;
while ((match = regex.exec(contentTruth)) !== null) {
    modules[match[1]] = match[0];
}
// Let's reset the offset of the regex
regex.lastIndex = 0;
var wrongContent = fs.readFileSync(wrong, 'utf8');
wrongContent = wrongContent.replace(regex, (match, moduleName) => {
  if (moduleName in modules) {
    return modules[moduleName];
  } else {
    return match;
  }
});
fs.writeFileSync(output, wrongContent);