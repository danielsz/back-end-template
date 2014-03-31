(ns {{ns-name}}.remote.monitor
  (:require [clojure.tools.nrepl :as repl]
            [clojure.pprint :refer (pprint)]
            [environ.core :refer [env]]))

(defn send-command
 "Send a command to a REPL"
 [commands & {:keys [host port] :or {host "localhost" port (Integer. (env :repl-port))}}]
 (for [command commands]
   (with-open [conn (repl/connect :host host :port port)] 
     (-> (repl/client conn 1000)
         (repl/message {:op :eval :code command})
         doall
         pprint))))
