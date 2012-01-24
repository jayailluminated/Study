require 'test/unit'

class MyFirstTest < Test::Unit::TestCase
  def setup
    @my_string = "Testing is fun!"
  end

  def test_length
    assert_equal 15, my_string.length
  end

  def test_emptiness
    assert_equal false, @my_string.empty?
  end

  def test_hash
    assert_equal "693492896", @my_string.hash.to_s
  end

  def teardown
    @my_string = nil
  end

end