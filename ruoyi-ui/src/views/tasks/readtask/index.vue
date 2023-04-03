<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="是否使用" prop="isUsed">
        <el-input
          v-model="queryParams.isUsed"
          placeholder="请输入是否使用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务标题" prop="rTitle">
        <el-input
          v-model="queryParams.rTitle"
          placeholder="请输入任务标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务起始时间" prop="rBegintime">
        <el-date-picker clearable
          v-model="queryParams.rBegintime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择任务起始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="任务结束时间" prop="rEndtime">
        <el-date-picker clearable
          v-model="queryParams.rEndtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择任务结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="需要阅读时间" prop="rTime">
        <el-input
          v-model="queryParams.rTime"
          placeholder="请输入需要阅读时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['tasks:readtask:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['tasks:readtask:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['tasks:readtask:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['tasks:readtask:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="readtaskList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="是否使用" align="center" prop="isUsed" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="任务标题" align="center" prop="rTitle" />
      <el-table-column label="任务描述" align="center" prop="rSynopsis" />
      <el-table-column label="任务起始时间" align="center" prop="rBegintime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.rBegintime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="任务结束时间" align="center" prop="rEndtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.rEndtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="任务状态" align="center" prop="rStatus" />
      <el-table-column label="任务1url" align="center" prop="rTaskfirst" />
      <el-table-column label="任务2url" align="center" prop="rTasksecond" />
      <el-table-column label="需要阅读时间" align="center" prop="rTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['tasks:readtask:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['tasks:readtask:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改阅读任务对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="是否使用" prop="isUsed">
          <el-input v-model="form.isUsed" placeholder="请输入是否使用" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="任务标题" prop="rTitle">
          <el-input v-model="form.rTitle" placeholder="请输入任务标题" />
        </el-form-item>
        <el-form-item label="任务描述" prop="rSynopsis">
          <el-input v-model="form.rSynopsis" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="任务起始时间" prop="rBegintime">
          <el-date-picker clearable
            v-model="form.rBegintime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择任务起始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="任务结束时间" prop="rEndtime">
          <el-date-picker clearable
            v-model="form.rEndtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择任务结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="任务1url" prop="rTaskfirst">
          <el-input v-model="form.rTaskfirst" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="任务2url" prop="rTasksecond">
          <el-input v-model="form.rTasksecond" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="需要阅读时间" prop="rTime">
          <el-input v-model="form.rTime" placeholder="请输入需要阅读时间" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listReadtask, getReadtask, delReadtask, addReadtask, updateReadtask } from "@/api/tasks/readtask";

export default {
  name: "Readtask",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 阅读任务表格数据
      readtaskList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        isUsed: null,
        remarks: null,
        rTitle: null,
        rSynopsis: null,
        rBegintime: null,
        rEndtime: null,
        rStatus: null,
        rTaskfirst: null,
        rTasksecond: null,
        rTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询阅读任务列表 */
    getList() {
      this.loading = true;
      listReadtask(this.queryParams).then(response => {
        this.readtaskList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        isUsed: null,
        createTime: null,
        updateTime: null,
        remarks: null,
        rTitle: null,
        rSynopsis: null,
        rBegintime: null,
        rEndtime: null,
        rStatus: null,
        rTaskfirst: null,
        rTasksecond: null,
        rTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加阅读任务";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getReadtask(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改阅读任务";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateReadtask(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addReadtask(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除阅读任务编号为"' + ids + '"的数据项？').then(function() {
        return delReadtask(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('tasks/readtask/export', {
        ...this.queryParams
      }, `readtask_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
