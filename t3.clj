
(defn gcd [a b] 
     (let [[x y] [(max a b) (min a b)]] 
        (if (= x y) x (recur y (- x y)))))

(println
   (for [x (range 1 1025) :when (= 0 (rem 1025 x))] x))

