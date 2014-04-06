(ns {{ns-name}}.framework.components.web-server
  (:require ({{ns-name}}.webapp [handler :refer [app app-with-debugging]])
            [com.stuartsierra.component :as component]
            [ring.adapter.jetty :refer [run-jetty]]))

(defrecord WebServer [port debug server]
  component/Lifecycle
  (start [component]
    (let [handler (if debug #'app-with-debugging #'app)
          server (run-jetty handler {:port (Integer. port) :join? false})]
      (assoc component :server server)))
  (stop [component]
    (when server
      (.stop server)
      component)))


(defn new-web-server
  [port debug]
  (map->WebServer {:port port :debug debug}))
