require 'test/unit'
require './driver.rb'
require './order-page.rb'


class TestValidDate < Test::Unit::TestCase
  include OrderPage
  def setup
    @driver = Driver.new
    @browser = @driver.start_driver
    @driver.set_normal_window_size @browser
    @driver.open_order_page @browser
  end

  def teardown
    @driver.stop_driver @browser
  end

  def test_not_valid_date
    click_one_way_only_box @browser
    input = origin_date_input @browser
    input.send_keys not_valid_date
    puts origin_date_alert(@browser).text
    puts bad_date_error_text
    assert_equal(origin_date_alert(@browser).text, bad_date_error_text)
  end
end