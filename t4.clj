(ns t4
  (require [exercise.func :refer :all]))

(def sqrt2 (take 20 (repeat 2)))
(def sqrt5 (take 20 (repeat 4)))
(def sqrt3 (take 20 (cycle [2 1])))
(def ex [[sqrt2 1] [sqrt3 1] [sqrt5 2]])

(defn calc_ratio [p] (- (fold_chain (first p)) (second p)))
(defn calc_double [p] (double (calc_ratio p)))

(println (map calc_double ex))

(println (unfold_chain 11/31))
(println (fold_chain [0 2 1 1 3 1 5 1 5 1]))
