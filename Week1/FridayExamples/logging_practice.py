import logging
# import logging.handlers
# import os

# Basic logging vs print

print(" [print] Application started") # no level, no timestamp
print(" [print] something went wrong" ) # no way to filter

print("\n Now with logging:")
logging.basicConfig(
    level = logging.DEBUG,
    format = "%(asctime)s | %(levelname)-8s | %(message)s",
    datefmt = "%H:%M:%S",
    force=True #Reset any previos config

)
logger = logging.getLogger("customLogger")
logger.debug("Detailed debug information")
logger.warning("this is a warning")
logger.info("info message")
logger.error("error message")
logger.critical("Critical Message")
