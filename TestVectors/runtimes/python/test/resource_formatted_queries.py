from boto3.dynamodb.conditions import Key, Attr

queries = {
    "RecNum = :zero": Key("RecNum").eq(":zero"),
    "RecNum = :one": Key("RecNum").eq(":one"), 
    "RecNum = :zero": Attr("RecNum").eq(":zero"),
    "RecNum <= :zero": Attr("RecNum").lte(":zero"),
    "RecNum > :zero": Attr("RecNum").gt(":zero"),
    "RecNum >= :zero": Attr("RecNum").gte(":zero"),
    "RecNum <> :zero": Attr("RecNum").ne(":zero"),
    "RecNum = :zero": Attr("RecNum").eq(":zero"),
    "RecNum = :one": Attr("RecNum").eq(":one"),
    "Nine between :zeroD and :three": Attr("Nine").between(":zeroD", ":three"),
    "Nine between :nineD and :nine": Attr("Nine").between(":nineD", ":nine"),
    "Nine between :nine and :three": Attr("Nine").between(":nine", ":three"),
    "Nine between :nine and :nine": Attr("Nine").between(":nine", ":nine"),
    "NumberTest = :NumberTest": Attr("NumberTest").eq(":NumberTest"),
    "RecNum in (:zero, :one)": Attr("RecNum").is_in([":zero", ":one"]),
    "Two = :two": {"expr": Attr("Two").eq(":two"), "Fail": ["4"]},
    "Two = :two or Three = :three or Four = :four OR Five = :five": {"expr": Attr("Two").eq(":two") | Attr("Three").eq(":three") | Attr("Four").eq(":four") | Attr("Five").eq(":five"), "Fail": ["4"]},
    "Two = :two and Three = :three and Four = :four and Five = :five": {"expr": Attr("Two").eq(":two") & Attr("Three").eq(":three") & Attr("Four").eq(":four") & Attr("Five").eq(":five"), "Fail": ["4"]},
    "Two in (:two, :three, :four, :five)": {"expr": Attr("Two").is_in([":two", ":three", ":four", ":five"]), "Fail": ["4"]},
    "Five in (:two, :three, :four, :five)": {"expr": Attr("Five").is_in([":two", ":three", ":four", ":five"]), "Fail": ["4"]},
    "Five in (:strset)": {"expr": Attr("Five").is_in(":strset"), "Fail": ["4"]},
    "Five in (:strlist)": {"expr": Attr("Five").is_in(":strlist"), "Fail": ["4"]},
    "contains(One, :oneA)": Attr("One").contains(":oneA"),
    "contains(One, :oneB)": Attr("One").contains(":oneB"),
    "contains(:oneA, One)": Attr(":oneA").contains("One"),
    "contains(:oneB, One)": Attr(":oneB").contains("One"),
    "contains(:strset, One)": Attr(":strset").contains("One")
}

complex_queries = [
    {
        "Config": "5",
        "Queries": [
            {
                "Filter": Attr("Comp1").eq(":cmp1a"),
                "Pass": [1],
                "Fail": [0]
            },
            {
                "Filter": Attr("Comp1").begins_with(":cmp1c"),
                "Pass": [1], 
                "Fail": [0]
            },
            {
                "Filter": Attr("Comp1").gte(":cmp1c"),
                "Pass": [1],
                "Fail": [0]
            },
            {
                "Filter": Attr("Comp1").gt("cmp1c"),
                "Fail": [0, 1]
            },
            {
                "Filter": Attr("Comp1").eq("cmp1c"),
                "Fail": [0, 1]
            },
            {
                "Filter": Attr("Comp1").begins_with(":cmp1d"),
                "Pass": [1],
                "Fail": [0]
            },
            {
                "Filter": Attr("Comp1").contains(":cmp1c"),
                "Pass": [1],
                "Fail": [0]
            },
            {
                "Filter": Attr("Comp1").contains(":cmp1d"),
                "Pass": [1],
                "Fail": [0]
            },
            {
                "Filter": Key("Comp1").eq(":cmp1b"),
                "Pass": [0],
                "Fail": [1]
            }
        ]
    }
]
