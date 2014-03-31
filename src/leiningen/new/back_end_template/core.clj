(ns {{ns-name}}.core
  (:gen-class)
  (:require [com.stuartsierra.component :as component]
            ({{ns-name}}.wiring 
             [application :refer [prod-system]])))

(def system
  "A Var containing an object representing the application under
  production."
  nil)

(defn -main 
  []
  "Start the application"
  (alter-var-root #'system (constantly (prod-system)))) 


