(ns json.core)




(defn parse-string [[f s third & the-rest]] 
	[s the-rest])
(defn parse-int [[integer & the-rest]]
	[(Integer/parseInt integer) the-rest])

(defn parse-tokens [[f & the-rest :as everything]]
	(if (= "\"" f) (parse-string everything) (parse-int everything)))

(defn parse-array [[f s t & the-rest]]
	(let [parsed (first (parse-int [s]))] [[parsed] the-rest]))

(defn tokenize-string [input] 
	(re-seq #"[\[\]\{\},\"]|\d+|\w+" input))