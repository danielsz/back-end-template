(ns {{ns-name}}.remote.commands
  (:require ({{ns-name}}.remote [monitor :refer [send-command]])
            ({{ns-name}}.wiring [utilities :refer [stringify-form]])
            [com.stuartsierra.component :as component]))


;; Just connect to the remote repl instead of serializing commands. 

(def debugging-cmd  
  '(let [component (:web {{ns-name}}.core/system)]
     (component/stop component)
     (->>
      %s
      (assoc component :debug)
      (assoc {{ns-name}}.core/system :web-server)
      (constantly)
      (alter-var-root #'{{ns-name}}.core/system))
     (component/start (:web {{ns-name}}.core/system))))

(defn toggle-debugging
  "Restart web server with debugging off"
  [& {:keys [toggle]}]
  (let [commands [(stringify-form debugging-cmd toggle)]]
    (send-command commands)))

;;(toggle-debugging :toggle false)





