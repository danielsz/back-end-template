(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [liberator "0.11.0"]
                 [ring "1.2.1"]
                 [compojure "1.1.6"]
                 [environ "0.4.0"]
                 [org.clojure/tools.nrepl "0.2.3"]
                 [com.stuartsierra/component "0.2.1"]
                 [com.datomic/datomic-free "0.9.4609"]
                 [com.novemberain/monger "2.0.0"]
                 [com.novemberain/langohr "2.11.0"]]
  :plugins [[lein-environ "0.4.0"]]
  :profiles {:dev {:dependencies [[ring-mock "0.1.5"]]
                   :source-paths ["dev"]
                   :env {:http-port 3000 :trace-headers true
                         :db-url "datomic:mem://localhost:4334/{{ns-name}}"}}
             :production {:env {:http-port 8000 :trace-headers false
                                :repl-port 8001
                                :db-url "datomic:free://localhost:4334/{{ns-name}}"
                                :mongo-url "mongodb://heroku_url"}}
             :uberjar {:aot :all}}
  :resource-paths ["resources"]
  :main {{ns-name}}.core)
