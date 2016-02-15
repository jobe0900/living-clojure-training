(ns training.core-test
  (:require [clojure.test :refer :all]
            [training.core :refer :all]))

(deftest test-1
  (testing "#1"
    (is (= sol-1 true))))

(deftest test-2
  (testing "#2" 
    (is (= (- 10 (* 2 3)) sol-2))))
