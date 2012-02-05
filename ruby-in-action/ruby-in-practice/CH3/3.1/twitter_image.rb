require 'rubygems'
require 'yaml'
require 'twitter'


fail "Usage:\n  ruby twitter_image.rb <message>\n" unless ARGV.first
images = File.readlines(File.join(File.dirname(__FILE__), 'images'))
fail "No images to twitter, images file is empty" if images.empty?
message = "#{ARGV.first} #{images.first}"

config = YAML.load(File.read(File.join(Gem.user_home, '.twitter')))

## twitterはbasic認証でもできなくなったので、これ以上このコードは動作しない
## oAuthを利用した認証に修正する必要がある。
# old version
twitter = Twitter::Base.new(config['email'], config['password'])

puts "Posting #{message} to twitter"
twitter.post(message)

File.open File.join(File.dirname(__FILE__), 'images'), 'w' do |file|
  file.write images[1..-1].join("\n")
end
