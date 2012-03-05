(ns json.test.core
  (:use [json.core])
  (:use [expectations]))

(comment expect 4 (json-parse "4"))
(comment expect 5 (json-parse "5"))
(comment expect "foo" (json-parse "\"foo\""))

(expect ["{", "}"] (tokenize-string "{}"))
(expect ["[", "]"] (tokenize-string "[]"))
(expect ["[", "15", "]"] (tokenize-string "[15]"))
(expect ["[", "15", "," , "16", "]"] (tokenize-string "[15,16]"))
(expect ["\"", "XYZ", "\"" ] (tokenize-string "\"XYZ\""))

(expect [15 ["foobar"]] (parse-int ["15", "foobar"]))
(expect ["blah" ["foobar"]] (parse-string ["\"", "blah" "\"", "foobar"]))

(expect [15 ["foobar"]] (parse-tokens ["15", "foobar"]))
(expect ["blah" ["foobar"]] (parse-tokens ["\"", "blah" "\"", "foobar"]))

(expect [[15] ["foobar"]] (parse-array ["[", "15", "]", "foobar"]))