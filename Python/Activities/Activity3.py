from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/login-form")

print("Page title is:", driver.title)

# Find fields
username = driver.find_element(By.ID, "username")
password = driver.find_element(By.ID, "password")

# Enter credentials
username.send_keys("admin")
password.send_keys("password")

# Click login
login = driver.find_element(By.XPATH, "//button[text()='Submit']")
login.click()

# Print login message
message = driver.find_element(By.XPATH, "//h1[contains(@class, 'text-center')]")
print("Login message:", message.text)

driver.quit()
