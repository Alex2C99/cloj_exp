(ns exercise.func)

(defn fib 
  ([n] (fib n [1 1]))
  ([n res]
    (let [[a1 a2] (take-last 2 res)]
      (if (< n 3) 
        res
        (recur (dec n) (conj res (+ a1 a2)))))))

(defn factorial
  ([n] (factorial n 1))
  ([n res]
    (if (< n 2)
      res
      (recur (dec n) (* res n)))))

(defn fib-lazy
  ([] (cons 1 (fib-lazy 1 1 )))
  ([a1 a2] (cons a2 (lazy-seq (fib-lazy a2 (+ a1 a2))))))

(defn gcd [a b] 
     (let [[x y] [(max a b) (min a b)]] 
        (if (= x y) x (recur y (- x y)))))

(defn eul [n] 
   (if (= 1 n) 1
       (count  (for [x (range 1 n) :when (= 1 (gcd x n))] x))))

(def euler 
   (for [x (range) :let [y (inc x)]] (eul y)))

(def cyclic
  (for [x (range) :let [y (inc x)] :when (= 1 (gcd y (eul y)))] y))

(defn isPrime [n]
  (let [sqn (int (+ (Math/sqrt n) 1))]
    (= 1 (count (for [x (range 1 sqn) :when (= 0 (rem n x))] x)))))

(def cyclicNp 
  (for [x (lazy-seq cyclic) :when (not (isPrime x)) :when (> x 1)] x))

(defn fold_chain [c] (reduce (fn [s n] (+ n (/ 1 s))) (reverse c)))

(defn unfold_chain 
   ([ r ] (let [[a b] [(numerator r) (denominator r)]] (unfold_chain a b)))
   ([ a b ]  (unfold_chain a b []))
   ([ a b l ]
        (if (= 0 b)
            l 
	        (recur b (mod a b) (conj l (int (/ a b)))))))
