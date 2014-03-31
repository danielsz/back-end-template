(ns leiningen.new.back-end-template
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "back-end-template"))

(defn back-end-template
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data ["src/{{sanitized}}/wiring/utilities.clj" (render "utilities.clj" data)]
["src/{{sanitized}}/core.clj" (render "core.clj" data)]
["src/{{sanitized}}/wiring/components/datomic.clj" (render "datomic.clj" data)]
["dev/user.clj" (render "user.clj" data)]
["src/{{sanitized}}/wiring/components/mongo.clj" (render "mongo.clj" data)]
["src/{{sanitized}}/webapp/resources.clj" (render "resources.clj" data)]
["src/{{sanitized}}/wiring/components/repl_server.clj" (render "repl_server.clj" data)]
["src/{{sanitized}}/wiring/application.clj" (render "application.clj" data)]
["src/{{sanitized}}/webapp/handler.clj" (render "handler.clj" data)]
["test/{{sanitized}}/wiring/components/web_server_test.clj" (render "web_server_test.clj" data)]
["src/{{sanitized}}/remote/commands.clj" (render "commands.clj" data)]
["src/{{sanitized}}/remote/monitor.clj" (render "monitor.clj" data)]
["test/{{sanitized}}/wiring/components/repl_server_test.clj" (render "repl_server_test.clj" data)]
["test/{{sanitized}}/wiring/components/mongo_test.clj" (render "mongo_test.clj" data)]
["project.clj" (render "project.clj" data)]
["test/{{sanitized}}/wiring/components/datomic_test.clj" (render "datomic_test.clj" data)]
["src/{{sanitized}}/wiring/components/web_server.clj" (render "web_server.clj" data)]
["test/{{sanitized}}/webapp/handler_test.clj" (render "handler_test.clj" data)]
)))