(ns t1
  (require [exercise.func :refer :all]))

(def num-fib 1000000)


(println
  (take 120 cyclicNp)
)

(comment

(let [less-sq (fn [lim x] (< (* x x) lim))] 
  (let [fl (into [] (take-while (partial less-sq num-fib) (fib-lazy)))]
    (println fl)))

)