(ns hla.photo
  (:require [mikera.image.core :as imagez]
            [mikera.image.colours :as colours]))

(def foo "bar")

(def image
  (imagez/load-image-resource "fixtures/medium_019d54ad-5db7-4bcd-9a73-580b5fed1c71.jpg"))

(defn width
  []
  (.getWidth image))

(defn height
  []
  (.getHeight image))

(defn pixels
  []
  (map colours/components-argb (imagez/get-pixels image)))

;; Hash of pixels as keys and counts as values
(def pixel-map (frequencies (pixels)))

