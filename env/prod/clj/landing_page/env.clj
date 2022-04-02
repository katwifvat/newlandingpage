(ns landing-page.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[landing-page started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[landing-page has shut down successfully]=-"))
   :middleware identity})
