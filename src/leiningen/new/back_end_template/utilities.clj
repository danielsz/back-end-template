(ns {{ns-name}}.framework.utilities)

(defmacro stringify-form [form & variables]
  (if variables
    `(format (str ~form) (str ~@variables))
    `(str ~form)))


(defn system-map []
  (if (bound? (ns-resolve '{{ns-name}}.core 'system))
    (deref (ns-resolve '{{ns-name}}.core 'system))
    (deref (ns-resolve 'user 'system))))


