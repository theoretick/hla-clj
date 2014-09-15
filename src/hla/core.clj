(ns hla.core
  (:require hla.photo hla.extensions))

(defn rate_by
  "Rates a given image by given extension"
  [ext]
    ;; TODO: Dynamically call given extension on photo
  )

(defn rate
  "Rate a given image per active extensions"
  []
  (reduce + (map (fn [e] (rate_by e)) hla.extensions/all)))

