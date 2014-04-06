(ns {{ns-name}}.framework.components.datomic-test
  (:require [{{ns-name}}.framework.components.datomic :refer [new-datomic-db]]
   [com.stuartsierra.component :as component]
   [datomic.api :as d]
   [clojure.test :refer [deftest is]]))

(def uri "datomic:mem://localhost:4334/twitter-fu-test")

(def datomic-db (new-datomic-db uri))
 
(deftest datomic-lifecycle
  (alter-var-root #'datomic-db component/start)
  (is (:connection datomic-db) "DB connection has been added to component")
  (is (d/db (:connection datomic-db)) "DB value received from connection")
  (is (d/delete-database uri) "Database deleted")  
  (alter-var-root #'datomic-db component/stop))
