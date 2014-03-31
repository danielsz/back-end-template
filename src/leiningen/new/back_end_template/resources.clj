(ns {{ns-name}}.webapp.resources
  (:require [liberator.core :refer [resource defresource]]))

(defresource bar
  :available-media-types ["text/html"]
  :handle-ok (format "<html>It's %d milliseconds since the end of the current epoch."
                     (System/currentTimeMillis)))
