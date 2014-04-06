(ns {{ns-name}}.framework.components.datomic
  (:require [com.stuartsierra.component :as component]
            [datomic.api :as d]))

(defrecord Datomic [uri connection]
  component/Lifecycle
  (start [component]
    (let [db (d/create-database uri)
          conn (d/connect uri)]
      (assoc component :connection conn)
      ;(d/transact conn schema)
      ;(d/transact conn (read-string (slurp "seed-data.edn")))
      ))
  (stop [component]
    (d/release connection)
    component))

(defn new-datomic-db [uri]
  (map->Datomic {:uri uri}))

