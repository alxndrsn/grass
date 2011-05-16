#!/bin/bash
jruby_version='1.6.1'
gem_name='compass'

build_dir="./$gem_name-gems"
jar_name="$gem_name-gems.jar"

wget http://jruby.org.s3.amazonaws.com/downloads/$jruby_version/jruby-complete-$jruby_version.jar

java -jar jruby-complete-$jruby_version.jar -S gem install -i $build_dir $gem_name --no-rdoc --no-ri
jar cf $jar_name -C $build_dir .

jar tf $jar_name | less

java -cp jruby-complete-$jruby_version.jar:$jar_name org.jruby.Main -S $gem_name -h | less

