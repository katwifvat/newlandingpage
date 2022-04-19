(ns landing-page.core
  (:require
   [goog.dom :as gdom]
   [reagent.dom :as rdom]
   ))

(defn navigation-top []
  [:nav {:class      "navbar is-fixed-top is-white has-shadow py-3"
         :role       "navigation"
         :aria-label "main navigation"}
   [:div {:class "container"}
    [:div {:class "navbar-brand"}
     [:a {:class "navbar-item"
          :href  "/"}
      [:img {:src "img/grouppy.png"}]]
     [:span {:class "navbar-burger burger"}
      [:span] [:span] [:span]]]
    [:div {:id    "navbar"
           :class "navbar-menu"}
     [:div {:class "navbar-end"}
     ;  [:a {:class "navbar-item"
      ;     :href  "/contact"
      ;     :style {:font-weight "bold"}} "Contact"]]
      ]
  ]]])

(defn level-separator
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
     [:div {:class "column is-vcentered"} 
      [:div {:class "content"}
       [:h2 "Join study groups online."]
       [:p "Learn, make friends and mentor others in supportive groups."]
       [:p [:a {:href   "https://discord.gg/xrSqtpd4E6"}
            "Art History"]]
       [:p [:a {:href   "https://discord.gg/TEB7SU6Ark"}
            "Clojure Web Development"]]
       [:p [:a {:href   "https://discord.gg/HPBMzu49aT"}
            "Cooking"]]
       [:p [:a {:href   "https://discord.gg/am86saRyBc"}
            "EDM production"]]
       [:p [:a {:href   "https://discord.gg/Svn3rxXNSc"}
            "Ethereum DApps"]]
       [:p [:a {:href   "https://discord.gg/6sUVyWrWxg"}
            "Excel"]]
       [:p [:a {:href   "https://discord.gg/eKkwVeWjem"}
            "JavaScript"]]
       [:p [:a {:href   "https://discord.gg/rAbJYuD7Qe"}
            "Machine Learning"]]
       [:p [:a {:href   "https://discord.gg/Jfhbfg9dBT"}
            "No Code"]]
       [:p [:a {:href   "https://discord.gg/Qwpx5kKhvW"}
            "Philosophy & Critical Theory"]]
       [:p [:a {:href   "https://discord.gg/mzz5EKzdyw"}
            "Psychology"]]
       [:p [:a {:href   "https://discord.gg/smFhwgz7XP"}
            "React"]]
       [:p [:a {:href   "https://discord.gg/UkXc9zQSxX"}
            "Tarot Card Reading"]]
       [:p [:a {:href   "https://discord.gg/bKnVvW4vzF"}
            "TypeScript"]]
       ]]]]])

(defn home-panel []
  [:div
   (level-separator "overview")
   [navigation-top]
   (level-separator "overview")
   [overview]])

(defmulti  panels identity)
(defmethod panels :home-panel [] [home-panel])

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
