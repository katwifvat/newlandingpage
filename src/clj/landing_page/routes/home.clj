(ns landing-page.routes.home
  (:require
   [landing-page.layout :as layout]
   [clojure.java.io :as io]
   [landing-page.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html"))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ])

