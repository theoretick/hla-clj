(ns hla.extensions.total_color
  (:require hla.photo))

;; Max colors of 255^3
(def max-rgb-colors 16581375)

(defn perform
  "Returns total colors relative to possible color total"
  []
  (float (/ (count hla.photo/colors)
            max-rgb-colors)))

