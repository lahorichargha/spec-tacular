(ns spark.sparkspec.test-specs
  {:core.typed {:collect-only true}}
  (:refer-clojure :exclude [assoc!])
  (:use spark.sparkspec
        spark.sparkspec.spec
        spark.sparkspec.datomic))

(defspec Scm2
  [val1 :is-a :long :unique :identity])

(defspec Scm
  [val1 :is-a :string :unique :identity]
  [val2 :is-a :long]
  [multi :is-many :string]
  (:link
   [scm2 :is-a :Scm2]))

(defspec Scm3)

(defenum ScmEnum :Scm2 :Scm3 :Scm)

(defspec ScmOwnsEnum
  (:link
   [enum :is-a :ScmEnum]
   [enums :is-many :ScmEnum]))

(defspec ScmM
  (:link
   [identity :is-a :string :unique :identity]
   [vals :is-many :Scm2]))

(defspec ScmParent
  (:link [scm :is-a :Scm]))

(defspec ScmReq
  [name :is-a :string :required])

(defspec ScmLink
  (:link 
   [link1 :is-a :Scm]
   [link2 :is-many :Scm2])
  [val1 :is-a :ScmParent])

(defspec ScmMWrap
  [name :is-a :string]
  (:link [val :is-a :ScmM]))
