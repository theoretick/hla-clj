(ns hla.extensions.color_variance_pop_var
  (:require hla.photo hla.stats))

;; weight of given extension
(def weight 1.0)

;; total possible variance of a 3pt dataset 0..255
(def max-variance 14450.0)

(defn pixel-variance
  "Normalized variance for individual pixel (rgb set)"
  [pixel]
  (/ (hla.stats/pop-var rgb) max-variance))

(defn normalized_variances
  "Sequence of each variance per pixel image"
  []
  (map (fn [rgb] (pixel-variance rgb)) hla.photo/colors)

(defn perform
  "Returns a value on a scale of 0 to 1 rating the amount of color variance in an image.
   This is calculated as a measure of avg variance per pixels, each relative
   to the total possible variance."
  []
  (*
    (hla.stats/mean normalized_variances)
    (hla.extensions.total_color/perform)
    weight))

