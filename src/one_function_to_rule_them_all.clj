(ns one-function-to-rule-them-all)

(defn concat-elements [a-seq]
  (reduce concat [] a-seq))

(defn str-cat [a-seq]
  (if (empty? a-seq)
    ""
    (reduce (fn [x y] (str x " " y)) a-seq)))

(defn my-interpose [x a-seq]
  (reduce (fn [acc elt] (if (empty? acc) [elt] (conj acc x elt))) [] a-seq))

(defn my-count [a-seq]
  (reduce (fn [acc x] (inc acc)) 0 a-seq))

(defn my-reverse [a-seq]
  (reduce (fn [acc elt] (cons elt acc)) '() a-seq))

(defn min-max-element [a-seq]
  (reduce (fn [acc elt] (if (empty? acc)
                          [elt elt]
                          (let [[cur-min cur-max] acc]
                            [(min cur-min elt) (max cur-max elt)]))) [] a-seq))

; When in doubt, use brute force
(defn insert [sorted-seq n]
  (let [lower (filter (fn [x] (< x n)) sorted-seq)
        higher (filter (fn [x] (> x n)) sorted-seq)]
    (concat lower (list n) higher)))

(defn insertion-sort [a-seq]
  (reduce (fn [acc n] (insert acc n)) '() a-seq))

(defn toggle [a-set elem]
  (if (contains? a-set elem)
    (disj a-set elem)
    (conj a-set elem)))

(defn parity [a-seq]
  (reduce (fn [acc elt] (toggle acc elt)) #{} a-seq))

(defn minus
  ([x] (- 0 x))
  ([x y] (- x y)))

(defn count-params [& params]
  (count params))

(defn my-* [& args]
  (reduce * 1 args))

(defn pred-and [x]
  (fn [x] :-))

(defn my-map [f a-seq]
  [:-])