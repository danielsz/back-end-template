(ns {{ns-name}}.webapp.handler 
  (:require 
   ({{ns-name}}.webapp [resources :refer [bar]])
   [liberator.dev :refer [wrap-trace]]
   [compojure.core :refer [defroutes GET]]
   [ring.middleware.resource :refer [wrap-resource]]   
   [ring.middleware.file-info :refer [wrap-file-info]]))


(defroutes routes
  (GET "/bar" [] bar))

(def app
  (-> routes 
      (wrap-resource "public")
      (wrap-file-info)))

(def app-with-debugging
  (-> app 
      (wrap-trace :header :ui)))
