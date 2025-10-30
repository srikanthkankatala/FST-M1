from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:
    wait = WebDriverWait(driver, 10)

    driver.get("https://training-support.net/webelements/dynamic-attributes")
    print("Page title is:", driver.title)

    # Wait for Full Name input field to be visible
    fullName = wait.until(EC.visibility_of_element_located((By.XPATH, "//input[@placeholder='Full Name']")))
    email = wait.until(EC.visibility_of_element_located((By.XPATH, "//input[@placeholder='Email']")))
    eventDate = wait.until(EC.visibility_of_element_located((By.XPATH, "//input[@placeholder='Event Date']")))
    details = wait.until(EC.visibility_of_element_located((By.XPATH, "//textarea[@placeholder='Additional Details']")))

    # Enter values
    fullName.send_keys("Raiden Shogun")
    email.send_keys("raiden@electromail.com")
    eventDate.send_keys("2025-06-26")
    details.send_keys("It will be electric!")

    # Click Submit
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()

    # Wait for success message
    message = wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation")))
    print("Success message:", message.text)
