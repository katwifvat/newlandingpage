(ns landing-page.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [landing-page.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[landing-page started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[landing-page has shut down successfully]=-"))
   :middleware wrap-dev})
