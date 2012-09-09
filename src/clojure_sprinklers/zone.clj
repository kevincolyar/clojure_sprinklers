(ns clojure-sprinklers.zone
 (:use clojure-sprinklers.solenoid))

(defn enable [board zone] 
  (enable-solenoid board zone))

(defn disable [board zone]
  (disable-solenoid board zone))

(defn enable-for-duration [board zone duration]
  (do 
    (enable board zone) 
    (Thread/sleep (* duration 1000))
    (disable board zone)
))


(defn enable-all [zones]
  (doseq [zone zones] (enable zone))
)

(defn disable-all [zones]
  (doseq [zone zones] (disable zone))
)
