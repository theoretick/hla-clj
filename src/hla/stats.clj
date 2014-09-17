(ns hla.stats
  (:require [clojure.math.numeric-tower :as math]))

(defn sum
  [data]
  (reduce + data))

(defn mean
  [data]
  (/ (sum data) (count data))

(defn absolute-deviations
  "Set of absolute deviations for given dataset"
  [data]
  (let [m (mean data)]
    (map (fn [x] (math/abs (- x m)))
      data)))

(defn max-absolute-deviation
  "Maximum absolute deviation from a given dataset"
  [data]
  (apply max (absolute-deviations data)))

(defn pop-var
  "Population Variance of given dataset"
  [data]
  (let [m (mean data)]
    (sum (reduce (fn [x] (math/expt (- x m) 2)) data))
)))

