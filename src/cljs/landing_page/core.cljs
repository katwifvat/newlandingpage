(ns landing-page.core
  (:require
   [goog.dom :as gdom]
   [reagent.dom :as rdom]
   ))

(defn contact []
  [:div {:class "container"}
   [:div {:class "box"}
    [:div {:class "columns"}
     [:div {:class "column"}
      [:figure {:class "image"}
       [:img {:src "img/group.png"}]]]
     [:div {:class "column"}
      [:div {:class "content"}
       [:h2 "ClojureBridge overview "]
       [:p "Fun, free and friendly workshops for those identifying as woman or non-binary gender."]
       [:p "Every student is paired with a coach who will support them through the workshop, helping them to relate to the concepts covered and
coaching them in the art of coding."]
       [:p "We teach students Clojure, a functional programming language that is great for beginners and experienced developers alike.  Find out " [:a {:href "#why-clojure"} "why Clojure is a great language to learn."]]
       [:p "Students can choose their own path in learning Clojure and we have put together content at different experience levels of experience."]
       [:p
        [:a {:href   "https://clojurebridgelondon.github.io/organise-clojurebridge-london/"
             :target "_blank"}
         "How to organise a ClojureBridge London event"]]]]]]])

(defn navigation-top []
  [:nav {:class      "navbar is-fixed-top is-white has-shadow py-3"
         :role       "navigation"
         :aria-label "main navigation"}
   [:div {:class "container"}
    [:div {:class "navbar-brand"}
     [:a {:class "navbar-item"
          :href  "/"}
      [:img {:src "img/snappylogo.png"}]]
     [:span {:class "navbar-burger burger"}
      [:span] [:span] [:span]]]
    [:div {:id    "navbarClojureBridge"
           :class "navbar-menu"}
     [:div {:class "navbar-end"}
      [:a {:class "navbar-item"
           :href  "/contact"
           :style {:font-weight "bold"}} "Contact"]]]]])

(defn level-separator
  "A separator to provide a gap between components.
  The separator takes an id so that the section
  does not get hidden by the menu when linking"
  [identifier]
  [:div {:class "level"
         :id    identifier}
   [:h5 {:class "is-size-5 is-invisible"}
    identifier]])

(defn overview
  []
  [:div {:class "container"}
   [:div {:class "box"}
    [:div {:class "columns"}
     [:div {:class "column"}
      [:figure {:class "image"}
       [:img {:src "img/groupy.png"}]]]
     [:div {:class "column"}

      [:div {:class "content"}
       [:h2 "This is a header"]
       [:p "This is a paragraph."]
       [:p "More paragraph."]
       [:p
        [:a {:href   "https://clojurebridgelondon.github.io/organise-clojurebridge-london/"
             :target "_blank"}
         "Example of a link"]]]]]]])

(defn contact-panel []
  [:div
   (level-separator "overview")
   [navigation-top]
   (level-separator "overview")
   [contact]])

(defn home-panel []
  [:div
   (level-separator "overview")
   [navigation-top]
   (level-separator "overview")
   [overview]])

(defmulti  panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :contact-panel [] [contact-panel])

(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [el]
  (rdom/render [home-panel] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

(mount-app-element)

;; specify reload hook with ^;after-load metadata
(defn ^:dev/after-load on-reload []
  (mount-app-element))

(defn init! []
  (mount-app-element))
