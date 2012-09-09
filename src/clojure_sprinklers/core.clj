(ns clojure-sprinklers.core
 (:use [clojure-sprinklers.zone :as zone])
 (:use cl-cronlike.core)
 (:use :reload-all clodiuno.core)
 (:use :reload-all clodiuno.firmata)
)

(def schedule
{
  :start "* * * * *",
  :zones [
    {:zone 1,  :duration 10}
    {:zone 2,  :duration 10}
    {:zone 3,  :duration 10}
    {:zone 4,  :duration 10}
    {:zone 5,  :duration 10}
    {:zone 6,  :duration 10}
  ]
})

(defn run-zones [zones]
  (let [board (arduino :firmata "/dev/tty.usbserial-A7006RMY")]
    (Thread/sleep 5000)
    (doseq [zone zones]
      (enable-for-duration board (zone :zone) (zone :duration)))
    (board close)
  )
) 

(defn -main
  [& args]
    (start-runner)
    (run-function-with-cron (schedule :start) (fn [] (run-zones (schedule :zones))))
)
