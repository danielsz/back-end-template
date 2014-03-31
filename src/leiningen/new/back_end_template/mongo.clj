(ns {{ns-name}}.wiring.components.mongo
  (:require [com.stuartsierra.component :as component]
            [monger.core :as mg]))

(defrecord Mongo [uri db]
  component/Lifecycle
  (start [component]
    (if uri 
      (do (mg/connect-via-uri! uri)
          (assoc component :db (mg/get-db)))
      (let [conn (mg/connect)]
        (assoc component :db (mg/get-db conn "mongo-dev")))))
  (stop [component]
    (if uri
      (assoc component :db (mg/disconnect!))
      (assoc component :db nil))))

(defn new-mongo-db
  ([]
     (map->Mongo {}))
  ([uri]
     (map->Mongo {:uri uri})))



