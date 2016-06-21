(def sum (fn [l] (reduce + l)))
(def avg (fn [l] (/ (sum l) (count l))))

(defn stats
  [numbers]
  (map (fn [f] (f numbers)) [sum count avg]))

(println (stats [5 3 4 6 8]))
