(ns clojure-sprinklers.solenoid
   (:use :reload-all clodiuno.core)
   (:use :reload-all clodiuno.firmata))

(defn enable-solenoid [board pin]
  (do 
    (println (str "Solenoid " pin " on" ))
    (pin-mode board (+ pin 1) OUTPUT)
    (digital-write board (+ pin 1) HIGH)
  )
)

(defn disable-solenoid [board pin]
  (do 
    (println (str "Solenoid " pin " off" ))
    (digital-write board (+ pin 1) LOW)
  )
)
