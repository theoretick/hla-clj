(ns hla.photo
  (:require [mikera.image.core :as imagez]))

(def foo "bar")

(def image
  (imagez/load-image-resource "fixtures/medium_019d54ad-5db7-4bcd-9a73-580b5fed1c71.jpg"))

(defn width
  []
  (.getWidth image))

(defn height
  []
  (.getHeight image))

(def pixels
  []
  (imagez/get-pixels image))

