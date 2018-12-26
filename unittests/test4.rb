require 'test/unit'
require './driver.rb'
require './order-page.rb'

class DestDateEarlierThanOrigin < Test::Unit::TestCase
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

  def test_dates
    click_one_way_only_box @browser
    click_on_return_box @browser
    input = origin_return_data_input @browser
    input_dest = destination_return_data_input @browser
    input.send_keys valid_date.to_s.split('-').reverse.join('/')
    input_dest.send_keys (valid_date - 1).to_s.split('-').reverse.join('/')
    click_on_return_box @browser
    assert_equal(origin_return_date_alert(@browser).text, bad_dep_date)
  end
end