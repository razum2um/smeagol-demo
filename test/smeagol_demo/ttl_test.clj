; Licensed to the Apache Software Foundation (ASF) under one
; or more contributor license agreements. See the NOTICE file
; distributed with this work for additional information
; regarding copyright ownership. The ASF licenses this file
; to you under the Apache License, Version 2.0 (the
; "License"); you may not use this file except in compliance
; with the License. You may obtain a copy of the License at
;
; http://www.apache.org/licenses/LICENSE-2.0
;
; Unless required by applicable law or agreed to in writing, software
; distributed under the License is distributed on an "AS IS" BASIS,
; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
; See the License for the specific language governing permissions and
; limitations under the License.
(ns smeagol-demo.ttl-test
  (:require
   [clojure.test :refer :all]
   [clojure.java.io :as io]
   [smeagol-demo.ttl :as sut]))

(def credit
     {:bank-balance 500.00
      :outstanding-invoices [{:name "customer1-no1"
                              :amount 119.00}
                             {:name "customer1-no2"
                              :amount 238.00}]
      :orders [{:recurrance :monthly
                :name "customer1"
                :amount 300.00}]})

(def debts (-> (io/resource "debts.edn") slurp clojure.edn/read-string))

(deftest server-spec
  (testing
    "test the server spec"
    (is (= 400.0
           (sut/calculate-debts-monthly debts)))))
