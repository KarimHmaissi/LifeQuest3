<div class="block span4 todo">
    <div class="block-heading">
        <span class="block-icon pull-right">
            <a href="#" class="demo-cancel-click" rel="tooltip" title="" data-original-title="Refresh"><i class="icon-refresh"></i></a>
        </span>

        <a href="#collapse-todo" data-toggle="collapse">Todo</a>
    </div>
    <div id="collapse-todo" class="block-body collapse in">

        <section id="todoapp">
            <header id="header">
                <input id="new-todo" placeholder="What needs to be done?" autofocus="">
            </header>
            <!-- This section should be hidden by default and shown when there are todos -->
            <section id="main">
                <ul id="todo-list">
                    <!-- These are here just to show the structure of the list items -->
                    <!-- List items should get the class `editing` when editing and `completed` when marked as completed -->
                    <li class="completed">
                        <div class="view">
                            <div class="todo-check"><div class="icheckbox_flat-red checked" style="position: relative;"><input class="toggle " type="checkbox" checked="" style="position: absolute; opacity: 0;"><ins style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background-color: rgb(255, 255, 255); border: 0px; opacity: 0; background-position: initial initial; background-repeat: initial initial;"></ins></div></div>
                            <label>Create a Todo/label&gt;
                                <button class="destroy"></button>
                            </label></div>
                        <input class="edit" value="Create a TodoMVC template">
                    </li>
                    <li>
                        <div class="view">
                            <div class="todo-check"><div class="icheckbox_flat-red" style="position: relative;"><input class="toggle" type="checkbox" style="position: absolute; opacity: 0;"><ins style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background-color: rgb(255, 255, 255); border: 0px; opacity: 0; background-position: initial initial; background-repeat: initial initial;"></ins></div></div>
                            <label>Add color theme</label>
                            <button class="destroy"></button>
                        </div>
                        <input class="edit" value="Rule the web">
                    </li>
                    <li>
                        <div class="view">
                            <div class="todo-check"><div class="icheckbox_flat-red" style="position: relative;"><input class="toggle" type="checkbox" style="position: absolute; opacity: 0;"><ins style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background-color: rgb(255, 255, 255); border: 0px; opacity: 0; background-position: initial initial; background-repeat: initial initial;"></ins></div></div>
                            <label>Remove edit class</label>
                            <button class="destroy"></button>
                        </div>
                        <input class="edit" value="Rule the web">
                    </li>
                    <li>
                        <div class="view">
                            <div class="todo-check"><div class="icheckbox_flat-red" style="position: relative;"><input class="toggle" type="checkbox" style="position: absolute; opacity: 0;"><ins style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background-color: rgb(255, 255, 255); border: 0px; opacity: 0; background-position: initial initial; background-repeat: initial initial;"></ins></div></div>
                            <label>Mark as read</label>
                            <button class="destroy"></button>
                        </div>
                        <input class="edit" value="Rule the web">
                    </li>
                    <li>
                        <div class="view">
                            <div class="todo-check"><div class="icheckbox_flat-red" style="position: relative;"><input class="toggle" type="checkbox" style="position: absolute; opacity: 0;"><ins style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background-color: rgb(255, 255, 255); border: 0px; opacity: 0; background-position: initial initial; background-repeat: initial initial;"></ins></div></div>
                            <label>Create a list item</label>
                            <button class="destroy"></button>
                        </div>
                        <input class="edit" value="Rule the web">
                    </li>
                </ul>
            </section>
            <!-- This footer should hidden by default and shown when there are todos -->
            <footer id="footer">
                <!-- This should be `0 items left` by default -->
                <span id="todo-count"><strong>1</strong> item left</span>
                <!-- Remove this if you don't implement routing -->
                <ul id="filters">
                    <li>
                        <a class="selected" href="#/">All</a>
                    </li>
                    <li>
                        <a href="#/active">Active</a>
                    </li>
                    <li>
                        <a href="#/completed">Completed</a>
                    </li>
                </ul>
                <button id="clear-completed">completed</button>
            </footer>
        </section>


    </div>
</div>