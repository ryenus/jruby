package org.jruby.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import java.nio.charset.Charset;

import org.jruby.CompatVersion;
import org.jruby.Ruby;
import org.jruby.RubyDir;
import org.jruby.RubyInstanceConfig;
import org.junit.Before;
import org.junit.Test;

public class TestRubyDir {

    private Ruby runtime_19;

    @Before
    public void setUp() throws Exception {
        RubyInstanceConfig config_19 = new RubyInstanceConfig();
        config_19.setCompatVersion(CompatVersion.RUBY1_9);
        runtime_19 = Ruby.newInstance(config_19);
    }

    /**
     * This test needs to be run with JVM flag {@code -Dfile.encoding=GBK},
     * otherwise it will succeed without testing anything.
     */
    @Test
    public void testGetHomeDirectoryPath_19_GBK() {
        assumeTrue(Charset.defaultCharset().displayName().equals("GBK"));
        
        String expectedHome = System.getProperty("user.home");
        String actualHome = RubyDir.getHomeDirectoryPath(runtime_19.getCurrentContext()).toString();
        
        assertEquals(null, expectedHome, actualHome);
    }
}
