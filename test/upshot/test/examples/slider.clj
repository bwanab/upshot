;  Copyright (c) Dave Ray, 2012. All rights reserved.

;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this
;   distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns upshot.test.examples.slider
  (:use [upshot.core]))

(defn add-behaviors [root]
  (let [sl (select root [:#sl])]
    (config! sl :value-changing? (fn [e] (println e))))
  root)

(defn make-scene []
  (scene
   :root (border-pane
          :top (h-box
                :children [(button :text "current value")])
          :center (slider :id :sl
                          :min 0
                          :max 100
                          :value 40
                          :show-tick-labels? true
                          :show-tick-marks? true
                          :major-tick-unit 50
                          :minor-tick-count 5
                          :block-increment 10
                          :orientation :horizontal
                          ))
    :width 800.0
    :height 600.0
    :fill :black))

(defn run []
  (run-now
   (-> (stage :scene (make-scene))
       add-behaviors
      .show)))
(defn -main [& args]
  (run))
;(run)
