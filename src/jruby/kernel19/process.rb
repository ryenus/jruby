module Process
  # try Java 7 process launching support
  if ENV_JAVA['java.specification.version'] >= '1.7'
    def self.spawn(*args)
      JRuby::ProcessManager.spawn(*args)
    end
  else
    # old version
    def self.spawn(*args)
      _spawn_internal(*JRuby::ProcessUtil.exec_args(args))
    end
  end
end
