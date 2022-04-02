(ns landing-page.core-test
  (:require [cljs.test :refer-macros [is are deftest testing use-fixtures]]
            [pjstadig.humane-test-output]
            [landing-page.core :as rc]))

(deftest test-home
  (is (= true true)))

