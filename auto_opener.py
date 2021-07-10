from sys import exit
from threading import Thread
from time import sleep, strftime as get_date
import tkinter
from tkinter import messagebox
from webbrowser import open as open_URL

urls = [
    'https://oneoakland.webex.com/meet/chisnell',
    'https://oneoakland.webex.com/meet/david.weeks',
    'https://oneoakland.webex.com/meet/kirsten.williams',
    'https://oneoakland.webex.com/meet/mrcastle',
    'https://oneoakland.webex.com/meet/alec.snyder',
    'https://oneoakland.webex.com/meet/kristen.elsner',
    'https://oneoakland.webex.com/meet/jennifer.hull'
]
schedule = [
    {
        'Monday' : [('12:59:30', 0)],
        'Monday Wednesday Friday' : [('07:52:30', 1), ('09:24:30', 2), ('10:54:30', 3)],
        'Tuesday Thursday' : [('07:52:30', 4), ('09:24:30', 5), ('10:54:30', 6)],
    },
    {
        'Monday' : [('12:59:30', 0)],
        'Monday Wednesday Friday' : [('07:52:30', 4), ('09:24:30', 5), ('10:54:30', 6)],
        'Tuesday Thursday' : [('07:52:30', 1), ('09:24:30', 2), ('10:54:30', 3)],
    }
]
running = False
last_button = None
last_title = None

def create_button(context, text, x, y, width, function):
    button = tkinter.Button(context, command=function, text=text, font=('arial bold', 10,))
    button.place(x=x, y=y, width=width, height=30)
    return button

def auto_open(schedule):
    while running:
        current_time = get_date('%H:%M:%S')
        current_day = get_date('%A')

        for days in schedule:
            if days.find(current_day) != -1:
                for times in schedule[days]:
                    if current_time == times[0]:
                        open_URL(urls[times[1]])
                        sleep(2)
        sleep(0.5)
    exit()

def start_loop(schedule_choice, schedule, button):
    global running
    global last_button
    global last_title
    # makes sure you can't start another thread when one is already running
    if not running:
        schedule = schedule[schedule_choice]

        last_button = button
        last_title = last_button.cget('text')
        last_button.config(text='Running...')

        running = True
        Thread(target=auto_open, args=(schedule,)).start()

def stop_loop():
    global running
    global last_button
    global last_title
    # stops the thread and changes the button title back to what it was
    if running:
        last_button.config(text=last_title)
        running = False 

window = tkinter.Tk()
window.title('Auto Zoom Opener')
# these values must be converted to integers, because division returns floats
width = int(window.winfo_screenwidth()/2-150)
height = int(window.winfo_screenheight()/2-250)
window.geometry(f'500x315+{width}+{height}')

# the following positions seem random, but they are all spaced out perfectly and
# compensate for the different lengths and heights of window elements
title = tkinter.Label(window, text='Auto Zoom Opener', font=('arial bold', 12,))
title.place(x=150, y=30, width=200, height=15)

create_button(window, 'First', 55, 75, 90, lambda:open_URL(urls[1]))
create_button(window, 'Second', 155, 75, 90, lambda:open_URL(urls[2]))
create_button(window, 'Third', 255, 75, 90, lambda:open_URL(urls[3]))
create_button(window, 'Fourth', 355, 75, 90, lambda:open_URL(urls[4]))
create_button(window, 'Fifth', 100, 115, 90, lambda:open_URL(urls[5]))
create_button(window, 'Sixth', 200, 115, 90, lambda:open_URL(urls[6]))
create_button(window, 'Advisory', 300, 115, 90, lambda:open_URL(urls[0]))

auto_open_123 = create_button(window, 'Auto Open (1, 2, 3)', 175, 175, 150, lambda:start_loop(0, schedule, auto_open_123))
auto_open_456 = create_button(window, 'Auto Open (4, 5, 6)', 175, 215, 150, lambda:start_loop(1, schedule, auto_open_456))
create_button(window, 'Cancel', 205, 255, 90, stop_loop)

def ask_quit():
    global running
    if running:
        if tkinter.messagebox.askokcancel('Quit', 'The auto opener is still running, are you sure you want to quit?'):
            running = False
            window.destroy()
    else:
        window.destroy()
window.protocol('WM_DELETE_WINDOW', ask_quit)

window.mainloop()
